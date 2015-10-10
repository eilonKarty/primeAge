#!usr/bin/python

'''

This script generate all the view three classes.
 Template file is needed, contains the right varibales in format of $(VARIABLE_NAME)


'''

from sys import argv
import shutil
import os


def main(argv):
    if len(argv) != 2:
        print ('Usage: create_pView_classes TEMPLATE_FILE_PATH')


    os.mkdir('./level_1/')
    for class_name in l1_classes:
        generate_class(l1_classes, class_name, 1)

    os.mkdir('./level_2/')
    for class_name in l2_classes:
        generate_class(l2_classes, class_name, 2)

    os.mkdir('./level_3/')
    for class_name in l3_classes:
        generate_class(l3_classes, class_name, 3)

    os.mkdir('./level_4/')
    for class_name in l4_classes:
        generate_class(l4_classes, class_name, 4)

    os.mkdir('./level_5/')
    for class_name in l5_classes:
        generate_class(l5_classes, class_name, 5)




def generate_class(classes_list, class_name, level):
    base_class_path= classes_list.get(class_name)[0]
    level= str(level)
    file_path= './level_'+level+'/p'+class_name+'.java'
    shutil.copy(argv[1], 'temp')
    abstract= classes_list.get(class_name)[1]
    with open('temp', 'r+') as temp:
        final_file= open(file_path, 'w')
        for line in temp.readlines():
            line=line.replace('$(BASE_CLASS)', class_name)

            line=line.replace('$(pBASE_CLASS)', 'p'+class_name)
            line=line.replace('$(#_LEVEL)', level)
            if abstract:
                line=line.replace('$(ABSTRACT)', 'abstract ')
            else:
                line=line.replace('$(ABSTRACT)', '')
            line=line.replace('$(BASE_CLASS_PATH)', base_class_path)
            final_file.write(line)
    os.remove('temp')




l1_classes={    'AnalogClock': ['android.widget.AnalogClock', False], #deprecated in API 23
                'ImageView': ['android.widget.ImageView', False],
                'KeyboardView': ['android.inputmethodservice.KeyboardView', False],
                'MediaRouteButton': ['android.app.MediaRouteButton', False],
                'ProgressBar': ['android.widget.ProgressBar', False],
                'Space': ['android.support.v4.widget.Space', False],
                'SurfaceView': ['android.view.SurfaceView', False],
                'TextView': ['android.widget.TextView', False],
                'TextureView': ['android.view.TextureView', False],
                'ViewGroup': ['android.view.ViewGroup', True],
                'ViewStub':['android.view.ViewStub',False ] #final class
                }


l2_classes={    'FloatingActionButton': ['android.support.design.widget.FloatingActionButton', False],
                'ImageButton':['android.widget.ImageButton',False],
                'QuickContactBadge':['android.widget.QuickContactBadge',False], #implements View.OnClickListener
                'AbsSeekBar':['android.widget.AbsSeekBar',True],
                'ContentLoadingProgressBar': ['android.support.v4.widget.ContentLoadingProgressBar', False],
                'GLSurfaceView':['android.opengl.GLSurfaceView',False],
                'VideoView':['android.widget.VideoView',False],
                'AppCompatTextView':['android.support.v7.widget.AppCompatTextView',False],
                'Button':['android.widget.Button',False],
                'CheckedTextView':['android.widget.CheckedTextView',False],
                'Chronometer':['android.widget.Chronometer',False],
                'DigitalClock':['android.widget.DigitalClock',False], #deprecated in API 17- use TextClock instead
                'EditText':['android.widget.EditText',False],
                'RowHeaderView':['android.support.v17.leanback.widget.RowHeaderView',False], #final class
                'TextClock':['android.widget.TextClock',False],
                'AbsoluteLayout':['android.widget.AbsoluteLayout',False], #deprecated in API 3
                'AdapterView<T extends android.widget.Adapter>':['android.widget.AdapterView<T extends android.widget.Adapter>',True],
                'CoordinatorLayout':['android.support.design.widget.CoordinatorLayout',False],
                'DrawerLayout':['android.support.v4.widget.DrawerLayout',False],
                'FragmentBreadCrumbs':['android.app.FragmentBreadCrumbs',False], #deprecated in API 21
                'FrameLayout':['android.widget.FrameLayout',False],
                'GridLayout':['android.support.v7.widget.GridLayout',False],
                'LinearLayout':['android.widget.LinearLayout',False],
                'LinearLayoutCompat':['android.support.v7.widget.LinearLayoutCompat',False],
                'PagerTitleStrip':['android.support.v4.view.PagerTitleStrip',False],
                'RecyclerView':['android.support.v7.widget.RecyclerView',False],
                'RelativeLayout':['android.widget.RelativeLayout',False],
                'ShadowOverlayContainer':['android.support.v17.leanback.widget.ShadowOverlayContainer',False],
                'SlidingDrawer':['android.widget.SlidingDrawer',False], #deprecated in API 17
                'SlidingPaneLayout':['android.support.v4.widget.SlidingPaneLayout',False],
                'SwipeRefreshLayout':['android.support.v4.widget.SwipeRefreshLayout',False],
                'Toolbar':['android.support.v7.widget.Toolbar',False],
                'TvView':['android.media.tv.TvView',False],
                'ViewPager':['android.support.v4.view.ViewPager',False],
                }


l3_classes={    'ZoomButton': ['android.widget.ZoomButton', False], #implements View.OnLongClickListener
                'RatingBar':['android.widget.RatingBar',False],
                'QuickContactBadge': ['android.widget.QuickContactBadge', False],
                'SeekBar':['android.widget.SeekBar',False],
                'AppCompatButton': ['android.support.v7.widget.AppCompatButton', False],
                'CompoundButton': ['android.widget.CompoundButton', True],
                'AppCompatCheckedTextView': ['android.support.v7.widget.AppCompatCheckedTextView', False],
                'AppCompatEditText': ['android.support.v7.widget.AppCompatEditText', False],
                'AutoCompleteTextView': ['android.widget.AutoCompleteTextView', False],
                'ExtractEditText': ['android.inputmethodservice.ExtractEditText', False],
                'SearchEditText': ['android.support.v17.leanback.widget.SearchEditText', False],
                'WebView': ['android.webkit.WebView', False],
                'AbsListView': ['android.widget.AbsListView', True],
                'AbsSpinner': ['android.widget.AbsSpinner', True],
                'AdapterViewAnimator': ['android.widget.AdapterViewAnimator', True],
                'AppWidgetHostView': ['android.appwidget.AppWidgetHostView', False],
                'BaseCardView': ['android.support.v17.leanback.widget.BaseCardView', False],
                'BrowseFrameLayout': ['android.support.v17.leanback.widget.BrowseFrameLayout', False],
                'CalendarView': ['android.widget.CalendarView', False],
                'CardView': ['android.support.v7.widget.CardView', False],
                'CollapsingToolbarLayout': ['android.support.design.widget.CollapsingToolbarLayout', False],
                'DatePicker': ['android.widget.DatePicker', False],
                'HorizontalScrollView': ['android.widget.HorizontalScrollView', False],
                'MediaController': ['android.widget.MediaController', False],
                'NavigationView': ['android.support.design.widget.NavigationView', False],
                'NestedScrollView': ['android.support.v4.widget.NestedScrollView', False],
                'PercentFrameLayout': ['android.support.percent.PercentFrameLayout', False],
                'ScrollView': ['android.widget.ScrollView', False],
                'SearchOrbView': ['android.support.v17.leanback.widget.SearchOrbView', False],
                'TabHost': ['android.widget.TabHost', False],
                'TimePicker': ['android.widget.TimePicker', False],
                'TitleView': ['android.support.v17.leanback.widget.TitleView', False],
                'ViewAnimator': ['android.widget.ViewAnimator', False],
                'ActionMenuView': ['android.widget.ActionMenuView', False],
                'AppBarLayout': ['android.support.design.widget.AppBarLayout', False],
                'ListRowHoverCardView': ['android.support.v17.leanback.widget.ListRowHoverCardView', False],
                'ListRowView': ['android.support.v17.leanback.widget.ListRowView', False],
                'NumberPicker': ['android.widget.NumberPicker', False],
                'RadioGroup': ['android.widget.RadioGroup', False],
                'SearchView': ['android.widget.SearchView', False],
                'TabWidget': ['android.widget.TabWidget', False],
                'TableLayout': ['android.widget.TableLayout', False],
                'TableRow': ['android.widget.TableRow', False],
                'TextInputLayout': ['android.support.design.widget.TextInputLayout', False],
                'ZoomControls': ['android.widget.ZoomControls', False],
                'ActionMenuView': ['android.support.v7.widget.ActionMenuView', False],
                'SearchView': ['android.support.v7.widget.SearchView', False],
                'PagerTabStrip': ['android.support.v4.view.PagerTabStrip', False],
                'HorizontalGridView': ['android.support.v17.leanback.widget.HorizontalGridView', False],
                'VerticalGridView': ['android.support.v17.leanback.widget.VerticalGridView', False],
                'DialerFilter': ['android.widget.DialerFilter', False],
                'PercentRelativeLayout': ['android.support.percent.PercentRelativeLayout', False],
                'SearchBar': ['android.support.v17.leanback.widget.SearchBar', False],
                'TwoLineListItem': ['android.widget.TwoLineListItem', False], #deprecated in API 17
                }


l4_classes={    'AppCompatRatingBar': ['android.support.v7.widget.AppCompatRatingBar', False],
                'CheckBox': ['android.widget.CheckBox', False],
                'RadioButton': ['android.widget.RadioButton', False],
                'Switch': ['android.widget.Switch', False],
                'SwitchCompat': ['android.support.v7.widget.SwitchCompat', False],
                'ToggleButton': ['android.widget.ToggleButton', False],
                'AppCompatAutoCompleteTextView': ['android.support.v7.widget.AppCompatAutoCompleteTextView', False],
                'MultiAutoCompleteTextView': ['android.widget.MultiAutoCompleteTextView', False],
                'GridView': ['android.widget.GridView', False],
                'ListView': ['android.widget.ListView', False],
                'Gallery': ['android.widget.Gallery', False], #depracated in API 16
                'Spinner': ['android.widget.Spinner', False],
                'AdapterViewFlipper': ['android.widget.AdapterViewFlipper', False],
                'StackView': ['android.widget.StackView', False],
                'ImageCardView': ['android.support.v17.leanback.widget.ImageCardView', False],
                'TabLayout': ['	android.support.design.widget.TabLayout', False],
                'SpeechOrbView': ['android.support.v17.leanback.widget.SpeechOrbView', False],
                'FragmentTabHost': ['android.support.v4.app.FragmentTabHost', False],
                'ViewFlipper': ['android.widget.ViewFlipper', False],
                'ViewSwitcher': ['android.widget.ViewSwitcher', False],
                }


l5_classes={    'AppCompatCheckBox': ['android.support.v7.widget.AppCompatCheckBox', False],
                'AppCompatRadioButton': ['android.support.v7.widget.AppCompatRadioButton', False],
                'AppCompatMultiAutoCompleteTextView': ['android.support.v7.widget.AppCompatMultiAutoCompleteTextView', False],
                'ExpandableListView': ['android.widget.ExpandableListView', False],
                'AppCompatSpinner': ['android.support.v7.widget.AppCompatSpinner', False],
                'ImageSwitcher': ['android.widget.ImageSwitcher', False],
                'TextSwitcher': ['android.widget.TextSwitcher', False],
                }


if __name__ == '__main__':
    main(argv)
