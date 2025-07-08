const express = require("express");
const router = express.Router();
const auth = require("../middleware/auth");
const {
  postAnswer,
  getAnswersByQuestion,
  updateAnswer,
  deleteAnswer,
  voteAnswer,
  getAnswersByUser,
} = require("../controllers/answerController");

router.get("/question/:questionId", getAnswersByQuestion);
router.post("/question/:questionId", auth, postAnswer);
router.put("/:id", auth, updateAnswer);
router.delete("/:id", auth, deleteAnswer);
router.post("/:id/vote", auth, voteAnswer);
router.get("/byUser/:userId", getAnswersByUser);

module.exports = router;
