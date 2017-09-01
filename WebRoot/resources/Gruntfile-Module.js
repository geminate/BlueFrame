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
                    './module/css/bootstrap.css': './module/src/bootstrap-sass/bootstrap.scss'
                }
            }
        },
        //合并
        concat: {
            js: {
                src: ['./module/js/jquery.min.js',
                    './module/js/bootstrap.min.js',
                    './module/js/bootstrap-datetimepicker.js',
                    './module/js/bootstrap-datetimepicker.zh-CN.js',
                    './module/js/jquery.validate.min.js',
                    './module/js/additional-methods.min.js',
                    './module/js/jquery-confirm.min.js',
                    './module/js/jquery.dataTables.min.js',
                    './module/js/underscore-min.js',
                    './module/js/fileinput.min.js',
                    './module/js/fileinput-zh.js',
                    './module/js/select2.js',
                    './module/js/select2-zh-CN.js'
                ],
                dest: './build/module.js',
            },
            css: {
                src: ['./module/css/*.css',
                    './module/css/*/*.css'
                ],
                dest: './build/module.css',
            }
        },
        //JS 文件压缩
        uglify: {
            compressjs: {
                files: {
                    './build/module.min.js': ['./build/module.js']
                }
            }
        },
        cssmin: {
            css: {
                src: './build/module.css',
                dest: './build/module.min.css'
            }
        },
        watch: {
            bootstrap: {
                files: ['./module/src/bootstrap-sass/*/*.scss', './module/src/bootstrap-sass/*.scss'],
                tasks: ['sass','concat','cssmin']
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-sass');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.registerTask('build-Module', ['sass', 'concat', 'uglify', 'cssmin']);
    grunt.registerTask('watch-Module', ['sass', 'concat', 'uglify', 'cssmin', 'watch']);
};