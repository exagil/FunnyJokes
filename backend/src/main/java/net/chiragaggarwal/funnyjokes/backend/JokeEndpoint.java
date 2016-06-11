package net.chiragaggarwal.funnyjokes.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import net.chiragaggarwal.jokesrepository.Jokes;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        resource = "joke",
        namespace = @ApiNamespace(
                ownerDomain = "backend.funnyjokes.chiragaggarwal.net",
                ownerName = "backend.funnyjokes.chiragaggarwal.net",
                packagePath = ""
        )
)
public class JokeEndpoint {
    /**
     * This method gets a random <code>Joke</code>
     *
     * @return A random <code>Joke</code>
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        String jokeDescription = new Jokes().fetchDescription();
        return new Joke(jokeDescription);
    }
}
