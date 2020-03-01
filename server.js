const express = require('express');
const cors = require('cors');
const mongoose = require('mongoose');

// Environment variables
require('dotenv').config();

// Following for creating the express server
const app = express();
const PORT = process.env.PORT || 5000;

// Middleware (cors)
app.use(cors());
// Allows to parse json
app.use(express.json());

const uri = process.env.MONGODB_URI;

mongoose.connect(uri, {
  useNewUrlParser: true,
  useCreateIndex: true,
  useUnifiedTopology: true,
  useFindAndModify: false,
  dbName: 'developer-forum'
});

const connection = mongoose.connection;
connection.once('open', () => {
  console.log('MongoDB database connected...');
});

/* const playersRouter = require('./routes/players');
app.use('/api/players', playersRouter);
 */

// Starts the server
app.listen(PORT, () => {
  console.log(`Server is running on PORT: ${PORT}`);
});
