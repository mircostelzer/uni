const request = require('supertest');
const mongoose = require('mongoose');
const app = require('./app');

describe('POST /api/v1/booklendings', () => {

    beforeAll( async () => { // establish connection to db
        jest.setTimeout(8000);
        app.locals.db = await mongoose.connect(process.env.DB_URL);
        console.log('connected to db', process.env.DB_URL);
    });
    afterAll( () => { mongoose.connection.close(true); } );

    test('app module should be defined', () => {
        expect(app).toBeDefined();
    });

    test('GET / should return 200', () => {
        return request(app)
        .get('/')
        .expect(200);
    });

    test('GET /books should return 200', () => {
        return request(app)
        .get('/books')
        .expect(200);
    });

});