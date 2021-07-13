## Getting Started

```no-highlight
et get java-spring-api-marathon
cd java-spring-api-marathon
createdb my_sweet_tunes_development
idea .
```

## For those about to Rock...

The only thing better than writing code is writing music. This simple irrefutable fact has driven you to use your Java skills to find a better way to get your songs out and into the world.

Take a look at the provided migration, entity, and templates before getting started with the below.

### Create Your Repository, Service, and Controller

```no-highlight
As a musician
I want to share my songs with the world
So I can teach the world to rock
```

Acceptance Criteria:

1. Create a SongRepository.
2. Create a SongService that utilizes the SongRepository.
3. Create a SongController that utilizes the SongService.

- Don't worry about adding in any extra methods at this point. Only do what you need to create the classes/interfaces and link them together.

### List Your Songs

```no-highlight
As a musician
I want to see a listing of my songs
So that I can keep an itemized list
```

4. When a user navigates to `/songs` they should see a list of songs

### Limit the songs displayed

```no-highlight
As a musician
I want to throttle how many results show at once
Because I was rocking too hard
```

Acceptance Criteria:

5. Add in pagination
   - Update the SongRepository to extend the `PagingAndSortingRepository`
   - Update the SongService and Controller to handle pagination

### Create Your Songs via Web Form

```no-highlight
As a musician
I want to be able to enter songs via a form
To efficiently save my songs
```

6. When a user navigates to `/songs/new` they should see a form to add a new song.
7. Create a `@PostMapping` endpoint to persist user input
   - Saving your song successfully redirects the user to `/songs`
   - If it doesn't save successfully, we should remain on the form page.

### List Your Songs via API

```no-highlight
As a musician
I want to make my songs available via an API
So web crawlers can find me
```

8. Create a RestController for your songs
9. visiting `/api/v1/songs` should display a JSON of your songs

### Individual Song Detail via API

```no-highlight
As a musician
I want to be able to serve up a single song
So that people can embed my song
```

10. visiting `/api/v1/songs/{id}` should display a JSON for the song with the matching ID
    - ensure that the show endpoint has error handling and results in a 404 if the song is not found

## Non Core Stories

### Validate

```no-highlight
As a musician
I want to ensure the form is filled out correctly
So my fans don't see incorrect information
```

Acceptance Criteria:

- `Title`
  - Cannot be empty or just white space
  - Must be a string greater than 0 and less than 26 characters
  - Must be present
- `Genre`
  - Cannot be empty or just white space
  - Must be a string greater than 0 and less than 16 characters
  - Cannot contain numbers
- `Release Year`
  - Must be in the past
  - Must be 4 digits
  - Must be present
- `Explicit Content`
  - Must be present

### API-based Song Creation

```no-highlight
As a musician
I want to allow others to create songs
So that I don't have to do all the work
```

Acceptance Criteria:

- Create a PostMapping for the `SongsApiController`
- Ensure using CURL that the endpoint works as expected
