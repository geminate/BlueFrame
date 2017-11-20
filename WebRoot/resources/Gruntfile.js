module.exports = function (grunt) {

    var sassStyle = 'compressed';

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        //SASS 编译
        sass: {
            output: {
                options: {
                    style: sassStyle,
                    noCache: true
                },
                files: {
                    'build/custom.min.css': './scss/custom.scss'
                }
            }
        },
        //JS 文件检查
        jshint: {
            all: ['./src/*.js', './src/*/*.js']
        },
        //JS 文件合并
        concat: {
            my: {
                src: ['./src/*.js', './src/*/*.js'],
                dest: './build/custom.js',
            }
        },
        //JS 文件压缩
        uglify: {
            compressjs: {
                files: {
                    './build/custom.min.js': ['./build/custom.js']
                }
            }
        },
        //文件修改监控
        watch: {
            sass: {
                files: ['./scss/*/*.scss', './scss/*.scss'],
                tasks: ['sass']
            },
            scripts: {
                files: ['./src/*.js', './src/*/*.js'],
                tasks: ['concat', 'jshint', 'uglify']
            },
            livereload: {
                options: {
                    livereload: '<%= connect.options.livereload %>'
                },
                files: ['build/custom.css', 'js/custom.min.js']
            }
        },
        connect: {
            options: {
                port: 9000,
                open: true,
                livereload: 35729,
                hostname: 'localhost'
            },
            server: {
                options: {
                    port: 9003,
                    base: './'
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-sass');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-connect');

    grunt.registerTask('build-Sass', ['sass']);
    grunt.registerTask('build-Js', ['jshint', 'concat', 'uglify']);
    grunt.registerTask('task-watch', ['sass', 'jshint', 'concat', 'uglify', 'watch']);
    grunt.registerTask('task-run', ['sass', 'jshint', 'concat', 'uglify', 'connect', 'watch',]);

};
