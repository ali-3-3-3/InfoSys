const express = require("express");
const router = express.Router();
const auth = require("../middleware/auth");
const {
  createQuestion,
  getAllQuestions,
  getQuestionById,
  updateQuestion,
  deleteQuestion,
  voteQuestion,
  getQuestionsByUser,
} = require("../controllers/questionController");

router.get("/", getAllQuestions);
router.get("/:id", getQuestionById);
router.post("/", auth, createQuestion);
router.put("/:id", auth, updateQuestion);
router.delete("/:id", auth, deleteQuestion);
router.post("/:id/vote", auth, voteQuestion);
router.get("/byUser/:userId", getQuestionsByUser);

module.exports = router;
