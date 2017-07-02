# Docker Tag Manager

Docker tagging strategies are still in their infancy, and the docker cloud application uses deployment tags to keep track of what images are in what environment ( See https://docs.docker.com/docker-cloud/apps/deploy-tags/#automatic-deployment-tags).

While a DevOps team or Developers can figure this out, the process is pretty opaque to an individual who wants to verify tags from a non-technical position.

This application intends to bridge the gap by connecting to docker registries and retrieving tag lists. It will then display a view of all docker images and their associated tags, effectively representing the following command graphically:

```bash
docker images | grep <docker-image-digest>
```
    
The following command will print all images that share an image digest, meaning they are the same image.

This allows for us to easily see which tags point to which images as shown in the ASCII graphic below:

Currently, the strategy in mind is a numbered version strategy with alpha-numeric tags as reference pointers.

Sorted (Alphabetically) by Tag

    app:1.0
    app:1.1
    app:1.2
    app:1.3 ---------> rollback
    app:2.0 ---------> production
    app:2.1 ---------> qatesting
           \---------> perftesting
    app:2.2 ---------> latest
    app:latest ------> 2.2
    app:production --> 2.0
    app:perftesting -> 2.1
                  \--> qatesting
    app:qatesting ---> 2.1
                 \---> perftesting
    app:rollback ----> 1.3

The above structure, in whatever tag configuration, allows non-technical individuals to use a Filter to find the tag they are interested in viewing. This tag will point to all other references, and have the required information.

## Requirements:

- [ ] List all images, tags, and digests via DockerTagManager API
- [ ] Easily compare images, tags, and digests via DockerTagManager API
- [ ] Get all identical/matching items using digests via DockerTagManager API
- [ ] Specify Registry within API URL
- [ ] Store registries within application in centralized location
- [ ] Easily add new registries
- [ ] Support Secure and Insecure registries
- [ ] Support pagination for large registries
- [ ] Visually display and filter all registry items

## CI/CD
Jenkins automated builds using Jenkinsfiles. Successful builds result in an image push to this repository's docker registry.

## Resources:
Retrieving Image Digests
- https://stackoverflow.com/questions/35186693/what-is-the-docker-registry-v2-api-endpoint-to-get-the-digest-for-an-image
- https://stackoverflow.com/questions/39375421/can-i-get-an-image-digest-without-downloading-the-image
    - https://forums.docker.com/t/get-image-digest-from-remote-registry-via-api/9480

Retrieving all Image Tags
- https://docs.docker.com/registry/spec/api/#listing-image-tags