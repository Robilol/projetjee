const path = require('path'), resolve = path.resolve,
    CleanWebpackPlugin = require('clean-webpack-plugin'),
    ExtractTextPlugin = require("extract-text-webpack-plugin");
// const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    node:{
       fs: 'empty'
    },
    devtool: "source-map",
    entry: {
        main: './webpack/webpack.bootstrap.js'
    },
    output: {
        filename: 'app.js',
        path: resolve(__dirname, '..', 'dist')
    },
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                exclude: /(node_modules|bower_components)/,
                use: [
                    {
                        loader: 'babel-loader',
                        options: {
                            presets: ['@babel/preset-env', '@babel/react'],
                            sourceMap: true
                        }
                    }
                ]
            },
            {
                test: /\.s?css$/,
                use: ExtractTextPlugin.extract({
                    fallback: "style-loader",
                    use: [
                        {
                            loader: 'css-loader',
                            options: {
                                sourceMap: true
                            }
                        },
                        {
                            loader: 'sass-loader',
                            options: {
                                sourceMap: true
                            }
                        }
                    ]
                })
            },
            {
                test: /\.(png|gif|jpg|jpeg|woff|woff2|eot|ttf|otf)$/i,
                use: [
                    {
                        loader: 'file-loader',
                        options: {
                            name: '[path][hash].[ext]',
                        }
                    }
                ]
            },
        ]
    },
    plugins: [
        new CleanWebpackPlugin(['dist'], {
            root: resolve(__dirname, '..')
        }),
        // new HtmlWebpackPlugin({
        //     template: path.resolve(__dirname, '..', 'src', 'index.html')
        // }),
        new ExtractTextPlugin({
            filename: 'app.css'
        })
    ]
};