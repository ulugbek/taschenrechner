const { defineConfig } = require('@vue/cli-service')
module.exports = {
    devServer: {
        port: 3000,
        proxy: {
            '/': {
                target: 'http://localhost:8080',
                ws: false,
                changeOrigin: true
            }
        }
    }
}