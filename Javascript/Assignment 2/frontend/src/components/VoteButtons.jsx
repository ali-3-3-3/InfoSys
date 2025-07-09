import { useState, useEffect } from 'react';
import getUserFromToken from '../utils/getUserFromToken';

export default function VoteButtons({ id, type, currentVotes, onVote }) {
    const [userVote, setUserVote] = useState(null);

    // Fetch initial vote state when component mounts
    useEffect(() => {
      const fetchVoteState = async () => {
        const token = localStorage.getItem('token');
        if (!token) return;

        const url = type === 'question'
          ? `http://localhost:5000/api/questions/${id}`
          : `http://localhost:5000/api/answers/${id}`;

        const res = await fetch(url, {
          headers: {
            'Authorization': 'Bearer ' + token
          }
        });

        if (res.ok) {
          const data = await res.json();
          // Find the user's vote from the userVotes array
          const userVoteData = data.userVotes?.find(v => v.user === getUserFromToken());
          setUserVote(userVoteData?.vote || null);
        }
      };

      fetchVoteState();
    }, [id, type]);

    const handleVote = async (voteType) => {
      const token = localStorage.getItem('token');
      if (!token) return alert('You must be logged in to vote.');

      // If clicking the same vote type, we're toggling it off
      if (userVote === voteType) {
        voteType = null;
      }

      const url = type === 'question'
        ? `http://localhost:5000/api/questions/${id}/vote`
        : `http://localhost:5000/api/answers/${id}/vote`;

      const res = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + token,
        },
        body: JSON.stringify({ voteType }),
      });

      if (res.ok) {
        const data = await res.json();
        onVote(data.votes);
        setUserVote(data.userVote);
      } else {
        const error = await res.json();
        alert(error.error || 'Voting failed.');
      }
    };

    return (
      <div className="btn-group align-items-center me-3" role="group">
        <button
          type="button"
          className={`btn btn-outline-success ${userVote === 'up' ? 'active' : ''}`}
          onClick={() => handleVote('up')}
          aria-label="Upvote"
          disabled={userVote === 'down'}
        >
          👍
        </button>
        <span className="px-3 align-self-center fw-bold">{currentVotes}</span>
        <button
          type="button"
          className={`btn btn-outline-danger ${userVote === 'down' ? 'active' : ''}`}
          onClick={() => handleVote('down')}
          aria-label="Downvote"
          disabled={userVote === 'up'}
        >
          👎
        </button>
      </div>
    );
}
  
