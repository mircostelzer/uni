const express = require('express');
const app = express();
const books = require('./models/book');

app.get('/', (req, res) => {
    res.send('Hello World!');
});

app.get('/books', async (req, res) => {
    try {
        const data = await books.find();
        res.json(data);
    } catch (error) {
        res.status(500).json({message: error.message});
    }
});

module.exports = app;