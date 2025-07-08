Nur Aliya Bte Mohd Wari
A0264656U

=== SETUP INSTRUCTIONS ===

1. DATABASE SETUP
----------------
- Install MongoDB Community Edition from: https://www.mongodb.com/try/download/community
- Start MongoDB service on your machine
- The application will automatically create a database named "peerprep" when first run
- Default database connection string: mongodb://localhost:27017/peerprep

2. PROJECT STRUCTURE
-------------------
The project contains two main folders:
- frontend/ : React frontend application
- backend/  : Node.js backend server

3. BACKEND SETUP
---------------
a) Navigate to backend folder:
   cd backend

b) Install dependencies:
   npm install

c) Create a .env file in the backend folder with:
   PORT=5000
   MONGODB_URI=mongodb://localhost:27017/peerprep
   JWT_SECRET=your_jwt_secret_key_here

d) Start the backend server:
   npm start

The backend will run on http://localhost:5000

4. FRONTEND SETUP
----------------
a) Navigate to frontend folder:
   cd frontend

b) Install dependencies:
   npm install

c) Start the frontend application:
   npm start

The frontend will run on http://localhost:3000

5. APPLICATION FEATURES
----------------------
User Authentication:
- User registration with email and password
- User login/logout functionality
- JWT-based authentication system
- Protected routes for authenticated users

Questions:
- View all questions on the homepage
- Sort questions by "newest" or "hot" (most votes)
- Filter questions by tags
- Search questions by title or content
- Create new questions with title, content, and tags
- Edit and delete your own questions
- Vote on questions (upvote/downvote)

Answers:
- Post answers to questions
- Edit and delete your own answers
- Vote on answers
- Mark answers as accepted (question author only)
- Sort answers by votes or date

Profile Management:
- View user profiles
- See questions and answers posted by users
- Edit profile information
- View voting history

Additional Features:
- Responsive design for mobile and desktop
- Real-time validation for forms
- Rich text editor for questions and answers
- Tag system for organizing questions
- Error handling and user feedback
- Pagination for questions list

6. TESTING THE APPLICATION
-------------------------
- Open http://localhost:3000 in your web browser
- Register a new account or login with existing credentials
- Start asking questions, providing answers, and voting

7. TROUBLESHOOTING
-----------------
- If MongoDB connection fails, ensure MongoDB service is running
- Check if ports 3000 and 5000 are available
- For any dependency issues, try deleting node_modules folder and running npm install again

8. ADDITIONAL NOTES
------------------
- The application requires Node.js version 14 or higher
- Make sure to keep the backend server running while using the application
- All passwords are hashed before storing in the database
- JWT tokens are used for authentication
- The application follows RESTful API principles
- Frontend is built with React and Bootstrap for styling
- Backend uses Express.js and MongoDB for data storage
