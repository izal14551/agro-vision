'use strict';

const Hapi = require('@hapi/hapi');
const admin = require('firebase-admin');

// Inisialisasi Firebase Admin SDK
const serviceAccount = require('./serviceAccountKey.json');
admin.initializeApp({
    credential: admin.credential.cert(serviceAccount)
});

const init = async () => {

    const server = Hapi.server({
        port: process.env.PORT || 3000,
        host: '0.0.0.0'
    });

    server.route({
        method: 'POST',
        path: '/register',
        handler: async (request, h) => {
            const { email, password } = request.payload;
    
            try {
                // Create user in Firebase Authentication
                const userRecord = await admin.auth().createUser({
                    email,
                    password
                });
    
                // Save user data to Firestore
                const userRef = admin.firestore().collection('users').doc(userRecord.uid);
                await userRef.set({
                    email: userRecord.email,
                    // Add other user data here if needed
                });
    
                console.log('User successfully registered and saved to Firestore');
                return h.response({ uid: userRecord.uid, email: userRecord.email }).code(201);
            } catch (error) {
                console.error('Error registering user:', error);
                return h.response({ error: error.message }).code(400);
            }
        }
    });
    

    server.route({
        method: 'POST',
        path: '/login',
        handler: async (request, h) => {
            const { email, password } = request.payload;

            try {
                // Firebase Admin SDK tidak menyediakan cara langsung untuk verifikasi password
                // Sebagai gantinya, kita menggunakan createCustomToken
                const userRecord = await admin.auth().getUserByEmail(email);
                const idToken = await admin.auth().createCustomToken(userRecord.uid);
                return h.response({ idToken }).code(200);
            } catch (error) {
                return h.response({ error: error.message }).code(400);
            }
        }
    });

    await server.start();
    console.log('Server running on %s', server.info.uri);
};

process.on('unhandledRejection', (err) => {
    console.log(err);
    process.exit(1);
});

init();
