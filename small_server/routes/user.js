Object.assign = require('object-assign');   //노드 하위버전에서 assign 메서드 지원용 모듈
var express = require('express');
var router = express.Router();
var session = require('express-session');
var models = require('../models');
var fs = require('fs');
var path = require('path');
var mkdirp = require('mkdirp');
var multer = require('multer');
var config = require('../config/config.json')[process.env.NODE_ENV || "development"];



router.post('/setLocation',function(req,res,next){
	models.user.update({
      latitude: req.body.latitude,
      longitude: req.body.longitude
    }, {
      where: {uid: req.body.uid}
    }).then(()=>{
		res.send({result:true});
	}).catch(()=>{
		res.send({result:false});
	})
});




module.exports = router;