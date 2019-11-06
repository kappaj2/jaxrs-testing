package za.co.ajk.messenger.service;

import za.co.ajk.messenger.model.DatabaseSim;
import za.co.ajk.messenger.model.Profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<String, Profile> profileMap = DatabaseSim.getProfiles();

    public ProfileService() {
        Profile profile1 = new Profile(1l, "Profile1", "Andre", "Krappie", new Date());
        Profile profile2 = new Profile(2l, "Profile2", "Andre", "Krappie", new Date());
        Profile profile3 = new Profile(3l, "Profile3", "Andre", "Krappie", new Date());
        profileMap.put("Profile1", profile1);
        profileMap.put("Profile2", profile2);
        profileMap.put("Profile3", profile3);
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profileMap.values());
    }

    public Profile getProfile(String id) {
        return profileMap.get(id);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profileMap.size() + 1);
        profileMap.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        }
        profileMap.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile deleteProfile(String profileName) {
        return profileMap.remove(profileName);
    }
}
