// Simulating an API call
function fetchUserData(userId) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (userId > 0) {
        resolve({
          id: userId,
          username: "user123",
          email: "user@example.com",
        });
      } else {
        reject("Invalid user ID");
      }
    }, 1000);
  });
}

//Q1. Call `fetchUserData()` to fetch the user data for userId = 1
//and console.log the username
//Complete implementation...
fetchUserData(1)
  .then((user) => console.log(user.username))
  .catch((error) => console.error(error));

//Q2. Chain two promises:
//1. First fetch user data for userId = 1
//2. Then capitalize the username and return it
//3. Handle potential errors
//Complete implementation...
fetchUserData(1)
  .then((user) => user.username.toUpperCase())
  .then((capitalizedUsername) => console.log(capitalizedUsername))
  .catch((error) => console.error(error));

// Expected output:
// user123
// USER123
