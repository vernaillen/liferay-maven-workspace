'use strict';

var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');

liferayThemeTasks.registerTasks({
	gulp: gulp,
	distName: "support-sample-theme-1.0.0",
	pathBuild: "./target/build-theme",
	pathDist: "./target"
});
