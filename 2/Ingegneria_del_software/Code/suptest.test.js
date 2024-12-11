import request from 'supertest';
import app from './server';
test('app module should be defined'
, () => {
expect(app).toBeDefined();
});
test('GET / should return 200', () => {
return request(app)
.get('/')
.expect(200);
});