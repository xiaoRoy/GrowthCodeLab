package com.learn.growthcodelab.fragment.state

interface SectionAContract {

    interface Presenter{
        fun viewSectionA()
    }

    interface ViewRenderer {
        fun displaySectionA(result: String)
    }

    interface Provider {
        fun loadSectionA(): String
    }

}

class SectionAPresenter(
        private val provider: SectionAContract.Provider,
        private val viewRenderer: SectionAContract.ViewRenderer
) : SectionAContract.Presenter{

    override fun viewSectionA() {
        viewRenderer.displaySectionA(provider.loadSectionA())
    }
}

class SectionAProvider : SectionAContract.Provider {

    override fun loadSectionA(): String {
        return "result of Section A"
    }
}