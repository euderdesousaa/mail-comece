/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
        "./src/main/resources/templates/**/*.{html, js}",
    ],
    theme: {
        extend: { colors:{
                azul1: '#4F3FFF',
                azul2: '#5D4FFB',
                azul3: '#756AF5',
                branco: '#F3F3F5',
                preto: '#2C2C2C'
            },
            backgroundImage: {
                "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
                "gradient-conic":
                    "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
            },
        },
    },
    plugins: [],
};