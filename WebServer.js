var express = require('express');
var mysql = require('mysql');
var app = express();
//var bodyParser = require('body-parser');
//const { response } = require('express');

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
    });
});

app.get('/', function(req, resp) {
    resp.render('index.ejs');
});
app.get('/success', function(req, resp) {
    resp.render('success.ejs');
});
app.post('/success', function(req, resp) {
    resp.redirect('/');
});
app.get('/fail', function(req, resp) {
    resp.render('fail.ejs');
});
app.post('/fail', function(req, resp) {
    resp.redirect('/');
});

app.get('/:id', function(req, resp) {
    //res.send('id: ' + req.params.id);
    con.query(("SELECT * FROM `objednani` WHERE id = '"+ req.params.id +"'"), function(err, result) {
        if (err) throw err;
        resp.send(result);
    });
});

app.get('/all', function(req, resp) {
    //res.send('id: ' + req.params.id);
    con.query(("SELECT * FROM `objednani`"), function(err, result) {
        if (err) throw err;
        resp.send(result[0]);
    });
});

/*app.post('?name&date&time&phone&spz&typeOfProblem', function(req, res) {
    const params = new URLSearchParams(window.location.search)
    var name = req.query.name;
    var date = req.query.date + " " + req.query.time;
    var phone = req.query.phone;
    var spz = req.query.spz;
    var typeOfProblem = req.query.typeOfProblem;
    console.log(req.params);
    console.log(date);
    console.log(phone);
    console.log(spz);
    console.log(typeOfProblem);

    con.query(("SELECT COUNT(*) AS datecheck FROM `objednani` WHERE datetime = '"+ date +"'"), function(err, result){
        if (err) throw err;
        if(result[0].datecheck > 1){
            console.log("preplneno");
            resp.redirect('/fail');
        } else {
            con.query(("INSERT INTO objednani (name, datetime, phone, spz, typeofproblem) " + "VALUES ('"+name+"','"+date+"','"+phone+"','"+spz+"','"+typeOfProblem+"')"), function (err, result) {
                if (err) throw err;
                console.log("uspech");
                resp.redirect('/success');
            });
        }
    });
});*/

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
                resp.redirect('/fail');
            } else {
                con.query(("INSERT INTO objednani (name, datetime, phone, spz, typeofproblem) " + "VALUES ('"+name+"','"+date+"','"+phone+"','"+spz+"','"+typeOfProblem+"')"), function (err) {
                    if (err) throw err;
                    console.log("uspech");
                    resp.redirect('/success');
                });
            }
        });
    } catch (err) {
        resp.redirect('/fail');
    }
});

app.listen(1337);