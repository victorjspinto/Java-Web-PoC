module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      build: {
        src: 'src/ts/**/*.js',
        dest: 'build/app.min.js'
      }
    },
    typescript: {
        base: {
            src: ['src/ts/**/*.ts'],
            //dest: 'js/PixelVisionJSDemos.js',
            options: {
                module: 'amd',
                target: 'es5'
            }
        }
    },
    watch: {
          files: 'src/ts/**/*.ts',
          tasks: ['typescript']
    },
    bower: {
      install: {
        options: {
          targetDir: './lib',
          layout: 'byComponent'
        }
       //just run 'grunt bower:install' and you'll see files from your Bower packages in lib directory
      }
    },
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-typescript');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-bower-task');
  
  // Default task(s).
  grunt.registerTask('default', ['watch']);
  grunt.registerTask('build', ['bower:install','typescript', 'uglify']);

};
