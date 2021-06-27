self.addEventListener('message',function(e){
    if(self.FileReader){
        var fr = new FileReader();
        console.time('Time for read');
        fr.readAsText(e.data[0],'utf-8');
        fr.onload = function(){
            let res = this.result;
            console.timeEnd('Time for read');
            self.postMessage(`End reading, words read ${res.length}`)
        }
    }
})