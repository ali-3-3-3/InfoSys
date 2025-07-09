import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function AskQuestionPage() {
  const [form, setForm] = useState({ title: '', body: '', tags: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm(prev => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const token = localStorage.getItem('token');
    if (!token) return alert('Please log in to post a question.');

    const res = await fetch('http://localhost:5000/api/questions', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token,
      },
      body: JSON.stringify({
        ...form,
        tags: form.tags.split(',').map(tag => tag.trim()),
      }),
    });

    if (res.ok) {
      const data = await res.json();
      navigate(`/questions/${data._id}`);
    } else {
      alert('Failed to post question');
    }
  };

  return (
    <div className="container mt-4">
      <div className="row justify-content-center">
        <div className="col-md-8">
          <div className="card shadow-sm">
            <div className="card-body">
              <h2 className="card-title mb-4">Ask a Question</h2>
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="title" className="form-label">Question Title</label>
                  <input
                    type="text"
                    id="title"
                    name="title"
                    className="form-control"
                    placeholder="e.g. How do I use useEffect in React?"
                    value={form.title}
                    onChange={handleChange}
                    required
                  />
                </div>
  
                <div className="mb-3">
                  <label htmlFor="body" className="form-label">Question Body</label>
                  <textarea
                    id="body"
                    name="body"
                    className="form-control"
                    rows="6"
                    placeholder="Explain your question in detail..."
                    value={form.body}
                    onChange={handleChange}
                    required
                  />
                </div>
  
                <div className="mb-3">
                  <label htmlFor="tags" className="form-label">Tags</label>
                  <input
                    type="text"
                    id="tags"
                    name="tags"
                    className="form-control"
                    placeholder="Comma-separated (e.g. react, express)"
                    value={form.tags}
                    onChange={handleChange}
                  />
                </div>
  
                <button type="submit" className="btn btn-primary">Post Question</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
  
}
