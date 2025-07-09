import { useEffect, useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

export default function ProfilePage() {
  const [profile, setProfile] = useState(null);
  const [editing, setEditing] = useState(false);
  const [form, setForm] = useState({});
  const [myQuestions, setMyQuestions] = useState([]);
  const [myAnswers, setMyAnswers] = useState([]);

  const navigate = useNavigate();

  const token = localStorage.getItem('token');

  useEffect(() => {
    if (!token) {
      alert('Please log in first.');
      return navigate('/login');
    }

    fetch('http://localhost:5000/api/users/me', {
      headers: {
        'Authorization': 'Bearer ' + token,
      },
    })
      .then(res => res.json())
      .then(data => {
        setProfile(data);
        setForm(data);
        Promise.all([
            fetch(`http://localhost:5000/api/questions/byUser/${data._id}`).then(res => res.json()),
            fetch(`http://localhost:5000/api/answers/byUser/${data._id}`).then(res => res.json())
          ]).then(([questions, answers]) => {
            setProfile(data);
            setForm(data);
            setMyQuestions(questions);
            setMyAnswers(answers);
          });
          
      });
    
  }, [token, navigate]);

  const handleChange = (e) => {
    setForm(prev => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      // Validate file type
      if (!file.type.startsWith('image/')) {
        alert('Please select an image file');
        return;
      }
      // Validate file size (e.g., 5MB max)
      if (file.size > 5 * 1024 * 1024) {
        alert('File size must be less than 5MB');
        return;
      }
      setForm(prev => ({ ...prev, profilePictureFile: file }));
    }
  };

  const handleSave = async () => {
    const formData = new FormData();
    
    // Always append text fields
    formData.append('username', form.username || '');
    formData.append('bio', form.bio || '');
    
    // Append file if it exists
    if (form.profilePictureFile) {
      formData.append('profilePicture', form.profilePictureFile);
    }

    try {
      const res = await fetch('http://localhost:5000/api/users/me', {
        method: 'PUT',
        headers: {
          'Authorization': 'Bearer ' + token,
        },
        body: formData,
      });

      if (res.ok) {
        const updated = await res.json();
        setProfile(updated);
        setForm(updated);
        setEditing(false);
        alert('Profile updated successfully!');
      } else {
        const error = await res.json();
        alert(error.error || 'Failed to update profile');
      }
    } catch (error) {
      console.error('Update error:', error);
      alert('Failed to update profile');
    }
  };
  

  if (!profile) return <p>Loading profile...</p>;

  return (
    <div className="container mt-4">
      <div className="card shadow-sm p-4 mb-4">
        <h2 className="card-title mb-3">My Profile</h2>
  
        <div className="d-flex align-items-center mb-4">
          <img
            src={
              form.profilePicture
                ? `http://localhost:5000${form.profilePicture}`
                : 'https://via.placeholder.com/150'
            }
            alt="profile"
            width={100}
            height={100}
            className="rounded-circle me-3 border"
            style={{ objectFit: 'cover' }}
          />
          <div>
            {editing ? (
              <>
                <div className="mb-2">
                  <label className="form-label">Username</label>
                  <input
                    name="username"
                    className="form-control"
                    value={form.username}
                    onChange={handleChange}
                    placeholder="Username"
                  />
                </div>
                <div className="mb-2">
                  <label className="form-label">Bio</label>
                  <textarea
                    name="bio"
                    className="form-control"
                    value={form.bio}
                    onChange={handleChange}
                    placeholder="Bio"
                  />
                </div>
                <div className="mb-2">
                    <label className="form-label">Profile Picture Upload</label>
                    <input
                        type="file"
                        className="form-control"
                        onChange={handleFileChange}
                        accept="image/*"
                    />
                </div>

                <div className="d-flex">
                  <button className="btn btn-success me-2" onClick={handleSave}>Save</button>
                  <button className="btn btn-secondary" onClick={() => setEditing(false)}>Cancel</button>
                </div>
              </>
            ) : (
              <>
                <p><b>Username:</b> {profile.username}</p>
                <p><b>Email:</b> {profile.email}</p>
                <p><b>Bio:</b> {profile.bio || <span className="text-muted">(no bio)</span>}</p>
                <button className="btn btn-outline-primary" onClick={() => setEditing(true)}>Edit Profile</button>
              </>
            )}
          </div>
        </div>
      </div>

      {/* My Questions Section */}
      <div className="card shadow-sm p-4 mb-4">
        <h3>My Questions</h3>
        {myQuestions.map(question => (
          <div key={question._id} className="card mb-3">
            <div className="card-body">
              <div className="d-flex justify-content-between">
                <h5>
                  <Link to={`/questions/${question._id}`}>
                    {question.title}
                  </Link>
                </h5>
                <div className="text-muted small">
                  <div>{question.votes} votes</div>
                  <div>{question.timestamp || 'Date unavailable'}</div>
                  {question.updatedAt !== question.createdAt && (
                    <div><em>(edited)</em></div>
                  )}
                </div>
              </div>
              <p className="text-truncate">{question.body}</p>
              <div>
                {question.tags.map((tag, idx) => (
                  <span key={idx} className="badge bg-secondary me-1">{tag}</span>
                ))}
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* My Answers Section */}
      <div className="card shadow-sm p-4">
        <h3>My Answers</h3>
        {myAnswers.map(answer => (
          <div key={answer._id} className="card mb-3">
            <div className="card-body">
              <div className="d-flex justify-content-between">
                <h5>
                  <Link to={`/questions/${answer.question._id}`}>
                    {answer.question.title}
                  </Link>
                </h5>
                <div className="text-muted small">
                  <div>{answer.votes} votes</div>
                  <div>{answer.timestamp || 'Date unavailable'}</div>
                  {answer.updatedAt !== answer.createdAt && (
                    <div><em>(edited)</em></div>
                  )}
                </div>
              </div>
              <p className="text-truncate">{answer.body}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
  
}
