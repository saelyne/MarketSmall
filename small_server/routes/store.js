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



router.get('/getStore/:id', function(req, res, next){
	models.items.findAll({
		where:{store_id: req.params.id}
	}).then((data)=>{
		res.send(data);
	}).catch(()=>{
		res.send({reult:false});
	});
});

router.get('/getStore',function(req,res,next){
	models.store.findAll().then((data)=>{
		res.send(data);
	}).catch(()=>{
		res.send({result:false});
	})
});	

router.post('/addStore',function(req,res,next){
	models.store.create({
		name: req.body.name,
		user_id: req.body.user_id
	}).then(()=>{
		res.send({result:true});
	}).catch(()=>{
		res.send({result:false});
	})
});

router.post('/addItem',function(req,res,next){
	models.items.create({
		name: req.body.name,
		price: req.body.price,
		store_id: req.body.store_id
	}).then(()=>{
		res.send({result:true});
	}).catch(()=>{
		res.send({result:false});
	})
});

router.post('/deleteItem/:id',function(req,res,next){
	models.items.destroy({
		where: {id: req.params.id}
	}).then(()=>{
		res.send({result:true});
	}).catch(()=>{
		res.send({result: false});
	})
});

router.get('/getOrder/:store_id',function(req,res,next){
	models.sales_order.findAll({
		where:{ store_id: req.params.store_id}
	}).then((data)=>{
		res.send(data);
	}).catch(()=>{
		res.send({result:false});
	})
});

module.exports = router;