'use strict';

var del = require('del');
var fs = require('fs');
var gulp = require('gulp');
var packageJSON = JSON.parse(fs.readFileSync('./package.json'));
var liferayThemeTasks = require('liferay-theme-tasks');

liferayThemeTasks.registerTasks({
	gulp: gulp,
	pathSrc: "src/main/webapp",
	pathBuild: "target/" + packageJSON.name + "-" + packageJSON.version,
	hookFn: function(gulp) {
		gulp.task('build:war', function() { });
		gulp.task('deploy:war', ['plugin:war', 'plugin:deploy'], del.bind(['dist']));
	}
});