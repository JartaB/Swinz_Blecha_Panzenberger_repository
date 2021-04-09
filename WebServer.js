var express = require('express');
var mysql = require('mysql');
var app = express();

app.use(express.static(__dirname + '/public'));
app.use(express.urlencoded({extended: false}));

var con = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'mysql'
});

con.connect(function(err) {
    if (err) throw err;
    con.query(("SELECT * FROM objednani"), function(err, result){
        if (err) throw err;
        console.log(result[0].datetime);
    })
});

app.get('/', function(req, resp) {
    resp.render('index.ejs')
});
app.get('/success', function(req, resp) {
    resp.render('success.ejs')
});
app.get('/fail', function(req, resp) {
    resp.render('fail.ejs')
});
app.post('/', function(req, resp) {
    try {
        var name = req.body.name;
        var date = req.body.date + " " + req.body.time;
        var phone = req.body.phone;
        var spz = req.body.spz;
        var typeOfProblem = req.body.typeOfProblem;

        con.query(("SELECT COUNT(*) AS datecheck FROM `objednani` WHERE datetime = '"+ date +"'"), function(err, result){
            if (err) throw err;
            if(result[0].datecheck > 1){
                console.log("preplneno");
            } else {
                con.query(("INSERT INTO objednani (name, datetime, phone, spz, typeofproblem) " + "VALUES ('"+name+"','"+date+"','"+phone+"','"+spz+"','"+typeOfProblem+"')"), function (err, result) {
                    if (err) throw err;
                    console.log("uspech");
                });
            }
        });
    } catch (error) {
        resp.redirect('/fail');
    }
});

app.listen(1337);

