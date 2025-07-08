const express = require("express");
const cors = require("cors");
const mongoose = require("mongoose");
const fileUpload = require('express-fileupload');
const path = require('path');
const fs = require('fs');
require('dotenv').config();

const app = express();

// Middleware
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Configure file upload middleware - place this BEFORE your routes
app.use(fileUpload({
  createParentPath: true,
  limits: {
    fileSize: 5 * 1024 * 1024 // 5MB max file size
  }
}));

// Create uploads directory if it doesn't exist
const uploadsDir = path.join(__dirname, 'uploads');
if (!fs.existsSync(uploadsDir)) {
  fs.mkdirSync(uploadsDir, { recursive: true });
}

// Serve uploaded files - make sure this path is absolute
app.use('/uploads', express.static(path.join(__dirname, 'uploads')));

// Routes
app.use("/api/users", require("./routes/users"));
app.use("/api/questions", require("./routes/questions"));
app.use("/api/answers", require("./routes/answers"));

// Connect to MongoDB
const connectDB = async () => {
  try {
    if (!process.env.MONGO_URI) {
      throw new Error('MONGO_URI is not defined in environment variables');
    }
    await mongoose.connect(process.env.MONGO_URI);
    console.log("MongoDB connected successfully");
  } catch (err) {
    console.error("MongoDB connection error:", err);
    process.exit(1);
  }
};

connectDB();

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
