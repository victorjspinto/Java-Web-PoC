module.exports = function (grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: ['src/config/**/*.js', 'src/controller/**/*.js', 'src/entity/**/*.js', 'src/service/**/*.js', 'src/util/**/*.js'],
                dest: 'build/app.min.js'
            }
        },

        ts: {            
            dev: {                                 // a particular target   
                src: ["src/app/**/*.ts"],        // The source typescript files, http://gruntjs.com/configuring-tasks#files
                html: ["src/**/*.tpl.html"], // The source html files, https://github.com/basarat/grunt-ts#html-2-typescript-support
                reference: "./src/app/reference.ts",  // If specified, generate this file that you can use for your reference management
                //out: 'test/out.js',                // If specified, generate an out.js file which is the merged js file                     
                outDir: 'src/app',    // If specified, the generate javascript files are placed here. Only works if out is not specified
                watch: 'src/app',                     // If specified, watches this directory for changes, and re-runs the current target  
                options: {                    // use to override the default options, http://gruntjs.com/configuring-tasks#options
                    target: 'es3',            // 'es3' (default) | 'es5'
                    module: 'amd',       // 'amd' (default) | 'commonjs'
                    sourcemap: true,          // true  (default) | false
                    declaration: false,       // true | false  (default)                
                    comments: false           // true | false (default)
                },
            },
            build: {                        // another target 
                src: ["src/**/*.ts"],
                options: {                  // overide the main options for this target 
                    sourcemap: false,
                }
            },
        },


        connect: {
            server: {
                options: {
                    port: 8080,
                    base: 'src/'
                }
            }
        },
        open: {
            dev: {
                path: 'http://localhost:8080/index.html'
            }
        }
    });

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-ts');
    
    grunt.loadNpmTasks('grunt-bower-task');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-open');

    // Default task(s).
    grunt.registerTask('default', ['connect', 'open', 'ts:dev']);
    grunt.registerTask('build', ['typescript', 'uglify']);

};
