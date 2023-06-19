package com.epam.rd.autocode.factory.plot;

class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return new PlotFactory() {
            @Override
            public String plot() {
                String heroName = hero.name();
                String belovedName = beloved.name();
                String villainName = villain.name();

                return String.format("%s is great. %s and %s love each other. %s interferes with their happiness but loses in the end.",
                        heroName, heroName, belovedName, villainName);
            }
        };
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return new PlotFactory() {
            @Override
            public String plot() {
                String heroName = hero.name();
                String epicCrisisName = epicCrisis.name();
                String funnyFriendName = funnyFriend.name();

                return String.format("%s feels a bit awkward and uncomfortable. But personal issues fades, when a big trouble comes - %s. %s stands up against it, but with no success at first.But putting self together and help of friends, including spectacular funny %s restore the spirit and %s overcomes the crisis and gains gratitude and respect",
                        heroName, epicCrisisName, heroName, funnyFriendName, heroName);
            }
        };
    }


    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return new PlotFactory() {
            @Override
            public String plot() {
                StringBuilder heroNames = new StringBuilder();
                for (Character hero : heroes) {
                    heroNames.append(hero.name()).append(", brave ");
                }
                heroNames.delete(heroNames.length() - 8, heroNames.length()); // Son "brave " ifadesini kaldır
                String epicCrisisName = epicCrisis.name();
                String villainName = villain.name();

                return String.format("%s threatens the world. But brave %s on guard. So, no way that intrigues of %s overcome the willpower of inflexible heroes",
                        epicCrisisName, heroNames, villainName);
            }
        };
    }
}
