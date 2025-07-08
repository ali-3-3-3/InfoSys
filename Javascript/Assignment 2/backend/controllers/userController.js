const User = require("../models/User");
const jwt = require("jsonwebtoken");
const bcrypt = require("bcryptjs");
const path = require("path");
const fs = require("fs");

exports.register = async (req, res) => {
  try {
    const { username, email, password, bio } = req.body;
    
    // Check if user already exists
    const existingUser = await User.findOne({ email });
    if (existingUser) {
      return res.status(400).json({ error: "Email already registered" });
    }

    const user = new User({
      username,
      email,
      password,
      bio
    });

    // Handle profile picture upload
    if (req.files && req.files.profilePicture) {
      const file = req.files.profilePicture;
      const filename = `${Date.now()}_${file.name}`;
      const uploadPath = path.join(__dirname, "..", "uploads", filename);

      await file.mv(uploadPath);
      user.profilePicture = `/uploads/${filename}`;
    }

    await user.save();
    res.status(201).json({ message: "User registered successfully" });
  } catch (error) {
    console.error('Registration error:', error);
    res.status(500).json({ error: "Registration failed" });
  }
};

exports.login = async (req, res) => {
  const { email, password } = req.body;
  const user = await User.findOne({ email });
  if (!user || !(await bcrypt.compare(password, user.password)))
    return res.status(401).json({ error: "Invalid credentials" });

  const token = jwt.sign({ id: user._id }, process.env.JWT_SECRET);
  res.json({ token });
};

exports.profile = async (req, res) => {
  const user = await User.findById(req.user.id);
  res.json(user);
};

exports.updateProfile = async (req, res) => {
  try {
    const user = await User.findById(req.user.id);
    if (!user) return res.status(404).json({ error: "User not found" });

    // Debug logs
    console.log('Files received:', req.files);
    console.log('Body received:', req.body);

    // Update text fields if provided
    if (req.body.username) user.username = req.body.username;
    if (req.body.bio) user.bio = req.body.bio;

    // Handle profile picture upload
    if (req.files && req.files.profilePicture) {
      const file = req.files.profilePicture;
      
      // Validate file type
      if (!file.mimetype.startsWith('image/')) {
        return res.status(400).json({ error: 'Please upload an image file' });
      }

      const filename = `${user._id}_${Date.now()}${path.extname(file.name)}`;
      const filepath = path.join(__dirname, '..', 'uploads', filename);

      // Delete old profile picture if it exists
      if (user.profilePicture) {
        const oldFilePath = path.join(__dirname, '..', user.profilePicture.replace(/^\/uploads\//, ''));
        if (fs.existsSync(oldFilePath)) {
          fs.unlinkSync(oldFilePath);
        }
      }

      // Move the new file
      try {
        await file.mv(filepath);
        user.profilePicture = `/uploads/${filename}`;
        console.log('File saved successfully:', filepath);
      } catch (fileError) {
        console.error('File upload error:', fileError);
        return res.status(500).json({ error: 'Failed to save file' });
      }
    }

    await user.save();
    res.json(user);
  } catch (error) {
    console.error('Update profile error:', error);
    res.status(500).json({ error: "Failed to update profile: " + error.message });
  }
};
