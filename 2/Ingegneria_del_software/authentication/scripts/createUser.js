const mongoose = require('mongoose');
const User = require('../model/User');

const DB = process.env.DB;

mongoose.connect(DB).then( async () => {
    
    console.log('Connected to MongoDB');
    
    const user = await new User()
    user.username = 'marco';
    user.password = '123';
    await user.save();

    console.log('User created');
    
} ).catch( (err) => {
    console.log('Failed to connect to MongoDB', err);
} );