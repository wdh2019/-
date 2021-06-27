const fs = require('fs');
const process = require('process');
let filePath = process.cwd() + '\\passage.txt';

//console.log(filePath);

fs.open(filePath,'r',(err,fd)=>{
    if(err){
        if(err.code === 'ENOENT'){
            console.log(`File:${filePath} doesn't exist!`);
        }
        else{
            console.log("error:",err);
        }
        return false;
    }
});

let buf;
//异步读
console.log("Start reading");
console.time("Time for read");
fs.readFile(filePath,(err,data)=>{
    if(err){
        console.log("error:",err);
        return false;
    }
    else{
        buf = data;
        console.timeEnd('Time for read');
        console.log(`End reading, words read: ${buf.length}`);
    }
});

//计算斐波那契数列
console.log("Start computing");
console.time("Time for computing");
let result = fn(44);
console.timeEnd("Time for computing");
console.log(`Finish computing, the result is ${result}`);


function fn(n){
    if(n === 0) return 0;
    if(n === 1) return 1;

    return fn(n-1)+fn(n-2);
}