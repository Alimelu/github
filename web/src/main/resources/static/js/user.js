const nowuser =window.location.pathname.substr(1);
const app = new Vue({
    el: '#app',
    data: {
        repositories: [],
        followers: [],
        followings: [],
    },
    methods: {
        searchRepository: function (event) {
            fetch(`/api/repository/${nowuser}`)
                .then(res => res.json())
                .then(res => {
                    console.log(res);
                    this.repositories = res;
                });
            $(event.target).tab('show');
        },
        searchFollowers: function (event) {
            fetch(`/api/follower/${nowuser}/`)
                .then(res => res.json())
                .then(res => {
                    console.log(res);
                    this.followers = res;

                });
            $(event.target).tab('show');
        },
        searchFollowing: function (event) {
            fetch(`/api/following/${nowuser}/`)
                .then(res => res.json())
                .then(res => {
                    console.log(res);
                    this.followings = res;

                });
            $(event.target).tab('show');
        },
    }
});
app.searchRepository();