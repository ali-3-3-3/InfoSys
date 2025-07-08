const mongoose = require("mongoose");

const questionSchema = new mongoose.Schema({
  title: String,
  body: String,
  tags: [String],
  author: { type: mongoose.Schema.Types.ObjectId, ref: "User" },
  votes: { type: Number, default: 0 },
  userVotes: [{
    user: { type: mongoose.Schema.Types.ObjectId, ref: "User" },
    vote: { type: String, enum: ['up', 'down'] }
  }]
}, {
  timestamps: true, // This adds createdAt and updatedAt fields automatically
  // Handle the case where timestamps aren't set
  timestamps: {
    currentTime: () => {
      const now = new Date();
      // Validate the timestamp
      return isNaN(now.getTime()) ? new Date(Date.now()) : now;
    }
  }
});

// Add a method to get formatted time
questionSchema.methods.getFormattedTimestamp = function() {
  try {
    const timestamp = this.createdAt || this.updatedAt || new Date();
    if (isNaN(timestamp.getTime())) {
      return 'Invalid Date';
    }
    
    const now = new Date();
    const diff = now - timestamp;
    const seconds = Math.floor(diff / 1000);
    const minutes = Math.floor(seconds / 60);
    const hours = Math.floor(minutes / 60);
    const days = Math.floor(hours / 24);

    if (days > 7) {
      return timestamp.toLocaleDateString('en-US', {
        year: 'numeric',
        month: 'short',
        day: 'numeric'
      });
    } else if (days > 0) {
      return `${days} day${days > 1 ? 's' : ''} ago`;
    } else if (hours > 0) {
      return `${hours} hour${hours > 1 ? 's' : ''} ago`;
    } else if (minutes > 0) {
      return `${minutes} minute${minutes > 1 ? 's' : ''} ago`;
    } else {
      return 'just now';
    }
  } catch (error) {
    console.error('Error formatting timestamp:', error);
    return 'Date unavailable';
  }
};

module.exports = mongoose.model("Question", questionSchema);
