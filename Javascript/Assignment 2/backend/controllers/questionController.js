const Question = require("../models/Question");

exports.getAllQuestions = async (req, res) => {
  try {
    const questions = await Question.find()
      .populate("author", "username")
      .sort({ createdAt: -1 });

    // Format the response with timestamps
    const formattedQuestions = questions.map(question => ({
      ...question.toObject(),
      timestamp: question.getFormattedTimestamp(),
      createdAt: question.createdAt,
      updatedAt: question.updatedAt
    }));

    res.json(formattedQuestions);
  } catch (error) {
    console.error('Error fetching questions:', error);
    res.status(500).json({ error: "Failed to fetch questions" });
  }
};

exports.getQuestionById = async (req, res) => {
  try {
    const question = await Question.findById(req.params.id)
      .populate("author", "username");
    
    if (!question) {
      return res.status(404).json({ error: "Question not found" });
    }

    const formattedQuestion = {
      ...question.toObject(),
      timestamp: question.getFormattedTimestamp(),
      createdAt: question.createdAt,
      updatedAt: question.updatedAt
    };

    res.json(formattedQuestion);
  } catch (error) {
    console.error('Error fetching question:', error);
    res.status(500).json({ error: "Failed to fetch question" });
  }
};

exports.createQuestion = async (req, res) => {
  const { title, body, tags } = req.body;
  const question = new Question({
    title,
    body,
    tags,
    author: req.user.id,
  });
  await question.save();
  res.status(201).json(question);
};

exports.updateQuestion = async (req, res) => {
  const question = await Question.findById(req.params.id);
  if (!question) return res.status(404).json({ error: "Not found" });
  if (question.author.toString() !== req.user.id)
    return res.status(403).json({ error: "Not allowed" });

  Object.assign(question, req.body);
  await question.save();
  res.json(question);
};

exports.deleteQuestion = async (req, res) => {
  const question = await Question.findById(req.params.id);
  if (!question) return res.status(404).json({ error: "Not found" });
  if (question.author.toString() !== req.user.id)
    return res.status(403).json({ error: "Not allowed" });

  await question.deleteOne();
  res.json({ message: "Deleted" });
};

exports.voteQuestion = async (req, res) => {
  const { voteType } = req.body; // 'up' or 'down' or null
  const question = await Question.findById(req.params.id);
  if (!question) return res.status(404).json({ error: "Not found" });

  // Check if user is voting on their own question
  if (question.author.toString() === req.user.id) {
    return res.status(403).json({ error: "Cannot vote on your own question" });
  }

  // Find existing vote
  const existingVoteIndex = question.userVotes.findIndex(
    vote => vote.user.toString() === req.user.id
  );

  // Remove existing vote if found
  if (existingVoteIndex > -1) {
    const existingVote = question.userVotes[existingVoteIndex];
    question.votes += existingVote.vote === 'up' ? -1 : 1;
    question.userVotes.splice(existingVoteIndex, 1);
  }

  // Add new vote if voteType is provided
  if (voteType) {
    question.votes += voteType === 'up' ? 1 : -1;
    question.userVotes.push({ user: req.user.id, vote: voteType });
  }

  await question.save();
  res.json({ 
    votes: question.votes,
    userVote: question.userVotes.find(v => v.user.toString() === req.user.id)?.vote || null
  });
};

exports.getQuestionsByUser = async (req, res) => {
  const questions = await Question.find({ author: req.params.userId }).sort({
    createdAt: -1,
  });
  res.json(questions);
};
