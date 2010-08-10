package com.todoroo.astrid.producteev;

import android.content.SharedPreferences.Editor;

import com.timsu.astrid.R;
import com.todoroo.astrid.common.SyncProviderUtilities;

/**
 * Displays synchronization preferences and an action panel so users can
 * initiate actions from the menu.
 *
 * @author timsu
 *
 */
public class ProducteevUtilities extends SyncProviderUtilities {

    /** add-on identifier */
    public static final String IDENTIFIER = "pdv"; //$NON-NLS-1$

    public static final ProducteevUtilities INSTANCE = new ProducteevUtilities();

    /** setting for dashboard to not synchronize */
    public static final int DASHBOARD_NO_SYNC = -1;

    /** setting for dashboard to use default one */
    public static final int DASHBOARD_DEFAULT = 0;

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public int getSyncIntervalKey() {
        return R.string.producteev_PPr_interval_key;
    }

    // --- producteev-specific preferences

    private static final String PREF_SERVER_LAST_SYNC = "_last_server"; //$NON-NLS-1$

    /** @return last sync date, or null if no last */
    public String getLastServerSync() {
        return getPrefs().getString(getIdentifier() + PREF_SERVER_LAST_SYNC, null);
    }

    /** Deletes Last Successful Sync Date */
    public void setLastServerSync(String value) {
        Editor editor = getPrefs().edit();
        editor.putString(getIdentifier() + PREF_SERVER_LAST_SYNC, value);
        editor.commit();
    }

    private ProducteevUtilities() {
        //
    }

}