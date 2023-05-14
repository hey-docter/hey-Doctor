$('subscribe-button').on('click', function() {
    Bootpay.requestSubscription({
        application_id: '6460d38c3049c8001d968686',
        pg: 'PG Symbol',
        price: 4990,
        tax_free: 0,
        order_name: '정기결제 입니다',
        subscription_id: (new Date()).getTime(),
        user: {
            username: '홍길동',
            phone: '01000000000'
        },
        extra: {
            subscription_comment: '매월 4,990원이 결제됩니다',
            subscribe_test_payment: true
        }
    }).then(
        function (response) {
            if (response.event === 'done') {
                alert('빌링키 발급이 완료되었습니다.')
            }
        },
        function (error) {
            console.log(error.message)
        }
    );
});