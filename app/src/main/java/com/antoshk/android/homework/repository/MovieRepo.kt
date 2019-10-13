package com.antoshk.android.homework.repository

class MovieRepo() {
    fun generateMovies(): List<Movie> {
        val result = mutableListOf<Movie>()
        result.add(
            Movie(
                "Jurassic World",
                "https://image.tmdb.org/t/p/w342/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg",
                "A new theme park, built on the original site of Jurassic Park, creates a genetically modified hybrid dinosaur, the Indominus Rex, which escapes containment and goes on a killing spree."
            )
        )
        result.add(
            Movie(
                "The Meg",
                "https://image.tmdb.org/t/p/w342/eyWICPcxOuTcDDDbTMOZawoOn8d.jpg",
                "A group of scientists exploring the Marianas Trench encounter the largest marine predator that has ever existed - the Megalodon."
            )
        )
        result.add(
            Movie(
                "The First Purge",
                "https://image.tmdb.org/t/p/w342/2slvblTroiT1lY9bYLK7Amigo1k.jpg",
                "America's third political party, the New Founding Fathers of America, comes to power and conducts an experiment: no laws for 12 hours on Staten Island. No one has to stay on the island, but \$5,000 is given to anyone who does."
            )
        )
        result.add(
            Movie(
                "Deadpool 2",
                "https://image.tmdb.org/t/p/w342/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg",
                "Foul-mouthed mutant mercenary Wade Wilson (a.k.a. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg Cable."
            )
        )
        result.add(
            Movie(
                "Black Panther",
                "https://image.tmdb.org/t/p/w342/uxzzxijgPIY7slzFvMotPv8wjKA.jpg",
                "T'Challa, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger from his country's past."
            )
        )
        result.add(
            Movie(
                "Ocean's Eight",
                "https://image.tmdb.org/t/p/w342/MvYpKlpFukTivnlBhizGbkAe3v.jpg",
                "Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City's yearly Met Gala."
            )
        )
        result.add(
            Movie(
                "Interstellar",
                "https://image.tmdb.org/t/p/w342/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
            )
        )
        result.add(
            Movie(
                "Thor - Ragnarok",
                "https://image.tmdb.org/t/p/w342/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg",
                "Thor (Chris Hemsworth) is imprisoned on the planet Sakaar, and must race against time to return to Asgard and stop Ragnarök, the destruction of his world, at the hands of the powerful and ruthless villain Hela (Cate Blanchett)."
            )
        )
        result.add(
            Movie(
                "Guardians of the Galaxy",
                "https://image.tmdb.org/t/p/w342/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg",
                "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe."
            )
        )

        return result
    }
}