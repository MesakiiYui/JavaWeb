
option = {
    // title: {
    //     text: '基础雷达图'
    // },

    tooltip: {},
    color:['#00afef','#91cf50'],
    legend: {
        x:'center',
        y:'bottom',
        data: ['个人数据','全司平均'],
        textStyle: {
            color: '#fff',
            fontSize: 14,//字体大小
        }
    },
    radar: {
        // shape: 'circle',
        splitNumber: 0, // 雷达图圈数设置
        name: {
            textStyle: {
                color: '#fff',
                fontSize: 14,
                backgroundColor: 'rgba(255, 255, 255, 0)', //rgba设置透明度0
                borderRadius: 3,
                padding: [-10, -12]  // 控制文字padding
            }
        },
        indicator: [
            { name: '平均呼入时长', max: 6500},
            { name: '日均产能', max: 16000},
            { name: '呼入平均事后整理时长', max: 30000},
            { name: '平均呼出事后整理时长', max: 38000},
            { name: '平均呼出时长', max: 52000}
        ],
        splitArea : {
            show : false,
            areaStyle : {
                color: 'rgba(255,0,0,0)', // 图表背景的颜色
            },
        },
        splitLine : {
            show : true,
            lineStyle : {
                width : 2,
                color : 'rgba(131,141,158,1)', // 设置网格的颜色
            },
        },
    },
    series: [{
        name: '成绩',
        type: 'radar',
        // areaStyle: {normal: {}},
        data: [
            {
                value: [4300, 10000, 28000, 35000, 50000],
                name: '全司平均',
                symbol: 'circle',
                // 单个数据标记的图形。
                symbolSize: 12,

            },
            {
                value: [5000, 14000, 28000, 31000, 42000],
                name:  '个人数据',
                symbol: 'circle',
                // 单个数据标记的图形。
                symbolSize: 12,
            }
        ]
    }]
};

var myChart = echarts.init(document.getElementById('radarArea'));
myChart.setOption(option);
