# Github

A git server.

## Architecture & Roadmap

- Storage 
    - repositories
        - hard disk (=> NFS filesystem)
    - user, repositories metadata...
        - mysql
        - redis
- Web Service (Spring boot)
    - Subscription (Mail + Feed)
    - Online Repositories
- Git Service
    - RPC
    - SSH


## References

Many open-source documents and software inspired me.

- [GitLab Architecture Overview](https://docs.gitlab.com/ce/development/architecture.html)
