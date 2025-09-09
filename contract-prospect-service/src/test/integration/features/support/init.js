/* eslint new-cap: "off", no-invalid-this: "off" */

'use strict';

var apickli    = require('apickli');
var config     = require('../../config.json');


var domain = config.parameters.domain + ":" + config.parameters.port;
var protocol = config.parameters.protocol;
var basepath = config.parameters.basepath;


console.log('api parameters: [' + protocol + ', ' + domain + ', ' + basepath + ']');
console.log('api baseurl: [' + protocol + '://' + domain + basepath + ']');

module.exports = function() {
    // cleanup before every scenario
    this.Before(function(scenario, callback) {
        console.log('Before scenario hook');
        this.apickli = new apickli.Apickli(protocol, domain + basepath);
        this.apickli.storeValueInScenarioScope("domain", domain);
        this.apickli.storeValueInScenarioScope("developerApps", config.parameters.apps);
        this.apickli.setGlobalVariable("unitTesting", config.parameters.unitTesting);
		this.apickli.addRequestHeader("X-TestCase", scenario.getName());
        for (var parameter in config.parameters) {
            if (parameter != "apps") {
                console.log(parameter, config.parameters[parameter])
                this.apickli.storeValueInScenarioScope(parameter, config.parameters[parameter]);
            }
        }
        callback();
    });
};