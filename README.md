MVVVM architecture was used for application as is recommended by Google.
Glide was used for loading images.
ExoPlayer was used for playing videos as simplest default solution.
Time spent - 5-6h - bigest part of time was spent for ExoPlayer in recycler view implementation (I have never been working with ExoPlayer before)
 and adding certificate for stream.livestreamfails.com as trusted (it's expired right now).

Points to improve:
- use some DI istead of object singletones
- video playback - now it could produce OOM exception and still plays in background and when is scrolled out of screen
