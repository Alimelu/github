const loginName = $('#session-name').text();

const repos = new Vue({
    el: '#repos',
    data: {
        repositories: [],
    },
    methods: {
        searchRepository: function () {
            fetch(`/api/repository/${loginName}`)
                .then(res => res.json())
                .then(res => {
                    console.log(res);
                    this.repositories = res;
                });
        },
    }
});
repos.searchRepository();

const subs = new Vue({
    el: '#subs',
    data: {
        subscriptions: [],
    },
    methods: {
        moment: function () {
            return moment();
        },
        searchSubscriptions: function () {
            fetch(`/api/userSubscription/`)
                .then(res => res.json())
                .then(res => {
                    console.log(res);
                    this.subscriptions = res;
                });
        },
    }
});
subs.searchSubscriptions()

const recommends = new Vue({
    el: '#recommends',
    data: {
        recommends: [],
    },
    methods: {
        searchRepository: function () {
            fetch(`/api/random/repository/`)
                .then(res => res.json())
                .then(res => {
                    console.log(res);
                    this.recommends = res;
                });
        },
    }
});
recommends.searchRepository();