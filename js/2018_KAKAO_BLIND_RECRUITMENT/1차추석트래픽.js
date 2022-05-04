function solution(lines) {
    let timeTable = [];
    for(const line of lines){
        l = line.split(" ");
        let time = l[1].split(":");
        let end_h = parseInt(time[0]);
        let end_m = parseInt(time[1]);
        let end_s = parseFloat(time[2]);

        let end = end_h*60*60 + end_m*60 + end_s

        let start =  Math.round((end - l[2].slice(0,-1) + parseFloat(0.001))*1000) / 1000;
        // let start_h = parseInt(parseInt(start/60)/60);
        // let start_m = parseInt(start/60) % 60 ;
        // let start_s = parseFloat(parseFloat(start%60)%60)
        // start_s = Math.round(start_s * 1000) / 1000 //소수점 3자리까지

        //timeTable.push([start_h,start_m,start_s,end_h,end_m,end_s])
        timeTable.push([start,end])
    }
    // console.log(timeTable)

    let count = 0;
    let start_count;
    let end_count;
    for(const index in timeTable){
        let start_pivot = timeTable[index][0] + 1;
        let end_pivot = timeTable[index][1] + 1;
        start_count = 1;
        end_count = 1;
        // console.log('index : ',index,'start_end : ',start_pivot,' end_end : ',end_pivot)

        for(let i=parseInt(index)+1; i<timeTable.length; i++){
            // console.log('index : ',index,'-----------------')
            if(start_pivot > timeTable[i][0] ){ //다음 통신의 시작시간보다 
                start_count += 1;
                continue;
            }
            if(start_pivot > timeTable[i][1] ){ //다음 통신의 종료시간보디 
                start_count += 1;
                continue;
            }
        }     

        for(let i=parseInt(index)+1; i<timeTable.length; i++){
            if(end_pivot > timeTable[i][0] ){ //다음 통신의 시작시간보다
                // console.log(' - ',end_pivot,timeTable[i][0]) 
                end_count += 1;
                continue;
            }
            if(end_pivot > timeTable[i][1] ){ //다음 통신의 종료시간보디 
                end_count += 1;
                continue;
            }
        }     
        // console.log(count,start_count,end_count)
        if(start_count > count){
            count = start_count;
        }   
        if(end_count > count){
            count = end_count;
        }   
    }
    return count;
}

lines =  [
    "2016-09-15 01:00:04.001 2.0s",
    "2016-09-15 01:00:07.000 2s"
    ]; // 1
lines =  [
    "2016-09-15 01:00:04.002 2.0s",
    "2016-09-15 01:00:07.000 2s"
    ]; // 2

result1 = solution(lines);
console.log(result1);