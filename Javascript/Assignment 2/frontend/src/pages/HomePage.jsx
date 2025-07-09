import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

export default function HomePage() {
  const [questions, setQuestions] = useState([]);
  const [allQuestions, setAllQuestions] = useState([]); // backup for filtering
  const [search, setSearch] = useState('');
  const [selectedTag, setSelectedTag] = useState('');
  const [sortBy, setSortBy] = useState('newest'); // Add sort state

  useEffect(() => {
    fetch('http://localhost:5000/api/questions')
      .then(res => res.json())
      .then(data => {
        setQuestions(data);
        setAllQuestions(data);
      });
  }, []);

  const uniqueTags = [...new Set(allQuestions.flatMap(q => q.tags))];

  const handleSearch = (e) => {
    const keyword = e.target.value;
    setSearch(keyword);
    filterAndSortQuestions(keyword, selectedTag, sortBy);
  };

  const handleTagChange = (e) => {
    const tag = e.target.value;
    setSelectedTag(tag);
    filterAndSortQuestions(search, tag, sortBy);
  };

  const handleSortChange = (e) => {
    const sort = e.target.value;
    setSortBy(sort);
    filterAndSortQuestions(search, selectedTag, sort);
  };

  const filterAndSortQuestions = (keyword, tag, sort) => {
    let filtered = allQuestions;

    // Apply filters
    if (keyword) {
      filtered = filtered.filter(q =>
        q.title.toLowerCase().includes(keyword.toLowerCase()) ||
        q.body.toLowerCase().includes(keyword.toLowerCase())
      );
    }

    if (tag) {
      filtered = filtered.filter(q => q.tags.includes(tag));
    }

    // Apply sorting
    filtered = [...filtered].sort((a, b) => {
      if (sort === 'hot') {
        return b.votes - a.votes;
      } else { // 'newest'
        return new Date(b.createdAt) - new Date(a.createdAt);
      }
    });

    setQuestions(filtered);
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-4">All Questions</h2>
  
      {/* Search + Filter Row */}
      <div className="row mb-4">
        <div className="col-md-6 mb-2">
          <input
            type="text"
            className="form-control"
            placeholder="Search for questions..."
            value={search}
            onChange={handleSearch}
          />
        </div>
        <div className="col-md-3 mb-2">
          <select
            className="form-select"
            value={selectedTag}
            onChange={handleTagChange}
          >
            <option value="">All Tags</option>
            {uniqueTags.map(tag => (
              <option key={tag} value={tag}>{tag}</option>
            ))}
          </select>
        </div>
        <div className="col-md-3 mb-2">
          <select
            className="form-select"
            value={sortBy}
            onChange={handleSortChange}
          >
            <option value="newest">Newest</option>
            <option value="hot">Hot</option>
          </select>
        </div>
      </div>

      {/* Questions List */}
      <div className="questions-list">
        {questions.map(question => (
          <div key={question._id} className="card mb-3 shadow-sm">
            <div className="card-body">
              <div className="d-flex justify-content-between">
                <h5 className="card-title">
                  <Link to={`/questions/${question._id}`} className="text-decoration-none">
                    {question.title}
                  </Link>
                </h5>
                <div className="text-muted small">
                  <div>{question.votes} votes</div>
                </div>
              </div>
              
              <p className="card-text text-truncate">{question.body}</p>
              
              <div className="d-flex justify-content-between align-items-end">
                <div>
                  {question.tags.map((tag, idx) => (
                    <span key={idx} className="badge bg-secondary me-1">{tag}</span>
                  ))}
                </div>
                
                <div className="text-muted small text-end">
                  <div>Asked by: {question.author?.username}</div>
                  <div>{question.timestamp || 'Date unavailable'}</div>
                  {question.updatedAt !== question.createdAt && (
                    <div><em>(edited)</em></div>
                  )}
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
