/* jshint node:true */
'use strict';

var apickli = require('apickli');
var config = require('../../test-config.json');

var domain = config.parameters.domain;
var protocol = config.parameters.protocol;

console.log('api parameters: [' + protocol + ', ' + domain + ']');
console.log('api baseurl: [' + protocol + '://' + domain + ']');

 module.exports = function() {
    // cleanup before every scenario
    this.Before(function(scenario, callback) {
        this.apickli = new apickli.Apickli(protocol, domain);
        callback();
    });

};
