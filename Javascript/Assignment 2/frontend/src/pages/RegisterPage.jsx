import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function RegisterPage() {
  const [form, setForm] = useState({
    username: '', 
    email: '', 
    password: '', 
    bio: ''
  });
  const [profilePicture, setProfilePicture] = useState(null);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    const formData = new FormData();
    formData.append('username', form.username);
    formData.append('email', form.email);
    formData.append('password', form.password);
    formData.append('bio', form.bio);
    if (profilePicture) {
      formData.append('profilePicture', profilePicture);
    }

    const res = await fetch('http://localhost:5000/api/users/register', {
      method: 'POST',
      body: formData, // Don't set Content-Type header - browser will set it with boundary
    });

    if (res.ok) {
      alert('Registered successfully!');
      navigate('/login');
    } else {
      const data = await res.json();
      alert(data.error || 'Failed to register');
    }
  };

  const handleChange = e => {
    setForm(prev => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleFileChange = (e) => {
    setProfilePicture(e.target.files[0]);
  };

  return (
    <div className="container d-flex justify-content-center align-items-center" style={{ minHeight: '90vh' }}>
      <div className="card shadow-sm p-4" style={{ width: '100%', maxWidth: '500px' }}>
        <h2 className="card-title text-center mb-4">Register</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Username</label>
            <input
              name="username"
              className="form-control"
              placeholder="Choose a username"
              onChange={handleChange}
              required
            />
          </div>
  
          <div className="mb-3">
            <label className="form-label">Email</label>
            <input
              name="email"
              type="email"
              className="form-control"
              placeholder="Enter your email"
              onChange={handleChange}
              required
            />
          </div>
  
          <div className="mb-3">
            <label className="form-label">Password</label>
            <input
              name="password"
              type="password"
              className="form-control"
              placeholder="Create a password"
              onChange={handleChange}
              required
            />
          </div>
  
          <div className="mb-3">
            <label className="form-label">Bio</label>
            <input
              name="bio"
              className="form-control"
              placeholder="Tell us about yourself"
              onChange={handleChange}
            />
          </div>
  
          <div className="mb-3">
            <label className="form-label">Profile Picture</label>
            <input
              type="file"
              className="form-control"
              onChange={handleFileChange}
              accept="image/*"
            />
          </div>
  
          <div className="d-grid">
            <button type="submit" className="btn btn-success">Register</button>
          </div>
        </form>
      </div>
    </div>
  );
}
