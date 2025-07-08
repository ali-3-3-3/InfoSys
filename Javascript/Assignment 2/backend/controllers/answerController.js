const Answer = require("../models/Answer");

exports.getAnswersByQuestion = async (req, res) => {
  try {
    const answers = await Answer.find({ question: req.params.questionId })
      .populate("author", "username")
      .sort({ createdAt: -1 });

    const formattedAnswers = answers.map(answer => ({
      ...answer.toObject(),
      timestamp: answer.getFormattedTimestamp(),
      createdAt: answer.createdAt,
      updatedAt: answer.updatedAt
    }));

    res.json(formattedAnswers);
  } catch (error) {
    console.error('Error fetching answers:', error);
    res.status(500).json({ error: "Failed to fetch answers" });
  }
};

exports.postAnswer = async (req, res) => {
  try {
    const answer = new Answer({
      body: req.body.body,
      question: req.params.questionId,
      author: req.user.id,
    });
    
    await answer.save();
    
    const formattedAnswer = {
      ...answer.toObject(),
      timestamp: answer.getFormattedTimestamp(),
      createdAt: answer.createdAt,
      updatedAt: answer.updatedAt
    };

    res.status(201).json(formattedAnswer);
  } catch (error) {
    console.error('Error posting answer:', error);
    res.status(500).json({ error: "Failed to post answer" });
  }
};

exports.updateAnswer = async (req, res) => {
  const answer = await Answer.findById(req.params.id);
  if (!answer) return res.status(404).json({ error: "Not found" });
  if (answer.author.toString() !== req.user.id)
    return res.status(403).json({ error: "Not allowed" });

  answer.body = req.body.body;
  await answer.save();
  res.json(answer);
};

exports.deleteAnswer = async (req, res) => {
  const answer = await Answer.findById(req.params.id);
  if (!answer) return res.status(404).json({ error: "Not found" });
  if (answer.author.toString() !== req.user.id)
    return res.status(403).json({ error: "Not allowed" });

  await answer.deleteOne();
  res.json({ message: "Deleted" });
};

exports.voteAnswer = async (req, res) => {
  const { voteType } = req.body; // 'up' or 'down' or null
  const answer = await Answer.findById(req.params.id);
  if (!answer) return res.status(404).json({ error: "Not found" });

  // Check if user is voting on their own answer
  if (answer.author.toString() === req.user.id) {
    return res.status(403).json({ error: "Cannot vote on your own answer" });
  }

  // Find existing vote
  const existingVoteIndex = answer.userVotes.findIndex(
    vote => vote.user.toString() === req.user.id
  );

  // Remove existing vote if found
  if (existingVoteIndex > -1) {
    const existingVote = answer.userVotes[existingVoteIndex];
    answer.votes += existingVote.vote === 'up' ? -1 : 1;
    answer.userVotes.splice(existingVoteIndex, 1);
  }

  // Add new vote if voteType is provided
  if (voteType) {
    answer.votes += voteType === 'up' ? 1 : -1;
    answer.userVotes.push({ user: req.user.id, vote: voteType });
  }

  await answer.save();
  res.json({ 
    votes: answer.votes,
    userVote: answer.userVotes.find(v => v.user.toString() === req.user.id)?.vote || null
  });
};

exports.getAnswersByUser = async (req, res) => {
  const answers = await Answer.find({ author: req.params.userId })
    .populate("question", "title")
    .sort({ createdAt: -1 });
  res.json(answers);
};
