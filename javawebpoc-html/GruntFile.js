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
    }
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-typescript');

  // Default task(s).
  grunt.registerTask('default', ['uglify']);

};
