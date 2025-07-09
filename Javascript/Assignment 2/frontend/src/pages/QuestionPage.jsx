import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import VoteButtons from '../components/VoteButtons';

export default function QuestionPage() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [question, setQuestion] = useState(null);
  const [answers, setAnswers] = useState([]);
  const [newAnswer, setNewAnswer] = useState('');
  const [currentUserId, setCurrentUserId] = useState(null);

  useEffect(() => {
    // Get current user ID from token
    const token = localStorage.getItem('token');
    if (token) {
      try {
        const payload = JSON.parse(atob(token.split('.')[1]));
        setCurrentUserId(payload.id);
      } catch (e) {
        console.error('Error decoding token:', e);
      }
    }

    // Fetch question data
    fetch(`http://localhost:5000/api/questions/${id}`)
      .then(res => res.json())
      .then(data => setQuestion(data));

    // Fetch answers
    fetch(`http://localhost:5000/api/answers/question/${id}`)
      .then(res => res.json())
      .then(data => setAnswers(data));
  }, [id]);

  const handleEdit = () => {
    const newTitle = prompt('Edit title:', question.title);
    const newBody = prompt('Edit body:', question.body);
    if (!newTitle || !newBody) return;
  
    fetch(`http://localhost:5000/api/questions/${question._id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.getItem('token'),
      },
      body: JSON.stringify({ title: newTitle, body: newBody }),
    }).then(res => {
      if (res.ok) {
        setQuestion(prev => ({ ...prev, title: newTitle, body: newBody }));
      } else {
        alert('Failed to edit');
      }
    });
  };
  
  const handleDelete = () => {
    if (!window.confirm('Delete this question?')) return;
  
    fetch(`http://localhost:5000/api/questions/${question._id}`, {
      method: 'DELETE',
      headers: { 'Authorization': 'Bearer ' + localStorage.getItem('token') },
    }).then(res => {
      if (res.ok) {
        alert('Deleted');
        navigate('/');
      } else {
        alert('Failed to delete');
      }
    });
  };
  
  const handleEditAnswer = (ans) => {
    const newBody = prompt('Edit answer:', ans.body);
    if (!newBody) return;
  
    fetch(`http://localhost:5000/api/answers/${ans._id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.getItem('token'),
      },
      body: JSON.stringify({ body: newBody }),
    }).then(res => {
      if (res.ok) {
        setAnswers(prev =>
          prev.map(a => a._id === ans._id ? { ...a, body: newBody } : a)
        );
      } else {
        alert('Failed to edit answer');
      }
    });
  };
  
  const handleDeleteAnswer = (answerId) => {
    if (!window.confirm('Delete this answer?')) return;
  
    fetch(`http://localhost:5000/api/answers/${answerId}`, {
      method: 'DELETE',
      headers: { 'Authorization': 'Bearer ' + localStorage.getItem('token') },
    }).then(res => {
      if (res.ok) {
        setAnswers(prev => prev.filter(a => a._id !== answerId));
      } else {
        alert('Failed to delete answer');
      }
    });
  };
  

  const handleSubmitAnswer = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
    if (!token) return alert('Please log in first.');

    const res = await fetch(`http://localhost:5000/api/answers/question/${id}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token,
      },
      body: JSON.stringify({ body: newAnswer }),
    });

    if (res.ok) {
      const answer = await res.json();
      setAnswers(prev => [answer, ...prev]);
      setNewAnswer('');
    } else {
      alert('Failed to post answer.');
    }
  };

  if (!question) return <p>Loading...</p>;

  return (
    <div className="container mt-4">
      {/* Question Section */}
      <div className="card mb-4 shadow-sm">
        <div className="card-body">
          <h3 className="card-title">{question.title}</h3>
          <p className="card-text">{question.body}</p>
  
          <div className="d-flex justify-content-between flex-wrap">
            <div>
              {question.tags.map((tag, idx) => (
                <span key={idx} className="badge bg-secondary me-1">{tag}</span>
              ))}
            </div>
            <div className="text-muted small">
              <div>Asked by: {question.author?.username}</div>
              <div>{question.timestamp || 'Date unavailable'}</div>
              {question.updatedAt !== question.createdAt && (
                <div><em>(edited)</em></div>
              )}
            </div>
          </div>
  
          <div className="d-flex align-items-center mt-3">
            <VoteButtons
              id={question._id}
              type="question"
              currentVotes={question.votes}
              onVote={(votes) => setQuestion(prev => ({ ...prev, votes }))}
            />
            <span className="ms-2">Votes: {question.votes}</span>
          </div>
  
          {currentUserId && question?.author && currentUserId === question.author._id && (
            <div className="mt-3">
              <button className="btn btn-outline-primary me-2" onClick={handleEdit}>Edit</button>
              <button className="btn btn-outline-danger" onClick={handleDelete}>Delete</button>
            </div>
          )}
        </div>
      </div>
  
      {/* Answers Section */}
      <div className="mb-4">
        <h4>Answers ({answers.length})</h4>
        {answers.map(answer => (
          <div key={answer._id} className="card mb-3 shadow-sm">
            <div className="card-body">
              <p className="card-text">{answer.body}</p>
              
              <div className="d-flex justify-content-between align-items-center">
                <div className="d-flex align-items-center">
                  <VoteButtons
                    id={answer._id}
                    type="answer"
                    currentVotes={answer.votes}
                    onVote={(votes) =>
                      setAnswers(prev =>
                        prev.map(a => (a._id === answer._id ? { ...a, votes } : a))
                      )
                    }
                  />
                  <span className="ms-2">Votes: {answer.votes}</span>
                </div>
                
                <div className="text-muted small">
                  <div>Answered by: {answer.author?.username}</div>
                  <div>{answer.timestamp || 'Date unavailable'}</div>
                  {answer.updatedAt !== answer.createdAt && (
                    <div><em>(edited)</em></div>
                  )}
                </div>
              </div>

              {currentUserId && answer?.author && currentUserId === answer.author._id && (
                <div className="mt-2">
                  <button
                    className="btn btn-outline-primary btn-sm me-2"
                    onClick={() => handleEditAnswer(answer)}
                  >
                    Edit
                  </button>
                  <button
                    className="btn btn-outline-danger btn-sm"
                    onClick={() => handleDeleteAnswer(answer._id)}
                  >
                    Delete
                  </button>
                </div>
              )}
            </div>
          </div>
        ))}
      </div>
  
      {/* Post Your Answer Section */}
      <div className="card shadow-sm">
        <div className="card-body">
          <h5 className="card-title">Post Your Answer</h5>
          <form onSubmit={handleSubmitAnswer}>
            <div className="mb-3">
              <textarea
                className="form-control"
                rows="4"
                value={newAnswer}
                onChange={e => setNewAnswer(e.target.value)}
                placeholder="Write your answer..."
                required
              />
            </div>
            <button type="submit" className="btn btn-success">Submit Answer</button>
          </form>
        </div>
      </div>
    </div>
  );
  
}
